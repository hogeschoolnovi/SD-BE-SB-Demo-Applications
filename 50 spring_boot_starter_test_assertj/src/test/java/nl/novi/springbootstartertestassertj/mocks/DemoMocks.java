package nl.novi.springbootstartertestassertj.mocks;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.AbstractList;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DemoMocks {

    public void setup() {
    }

    // configure simple return behavior for mock
    @Test
    public void simpleReturnBehaviour() {
        // given
        MyList listMock = Mockito.mock(MyList.class);        // mock
        when(listMock.add(anyString())).thenReturn(false);   // stub

        // when
        boolean added = listMock.add("abc");

        // then
        assertThat(added).isFalse();
    }

    // configure return behavior for mock in an alternative way
    @Test
    public void alternativeReturnBehaviour() {
        MyList listMock = Mockito.mock(MyList.class);
        doReturn(false).when(listMock).add(anyString());

        boolean added = listMock.add("abc");
        assertThat(added).isFalse();
    }

    // configure mock to throw an exception on a method call
    @Test(expected = IllegalStateException.class)
    public void givenMethodIsConfiguredToThrowException_whenCallingMethod_thenExceptionIsThrown() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);

        listMock.add("abc");
    }

    // configure the behavior of a method with void return type – to throw an exception
    @Test(expected = NullPointerException.class)
    public void configureReturnVoid() {
        MyList listMock = Mockito.mock(MyList.class);
        doThrow(NullPointerException.class).when(listMock).clear();

        listMock.clear();
    }

    // configure the behavior of multiple calls
    @Test(expected = IllegalStateException.class)
    public void configureMultipleCalls() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);

        listMock.add("abc");
        listMock.add("abc"); // will throw the exception
    }

    // configure the behavior of a spy
    @Test(expected = NullPointerException.class)
    public void configureSpy() {
        MyList instance = new MyList();
        MyList spy = Mockito.spy(instance);

        doThrow(NullPointerException.class).when(spy).size();
        spy.size(); // will throw the exception
    }

    // configure method to call the real, underlying method on a mock
    @Test
    public void configureCallUnderlying() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.size()).thenCallRealMethod();

        assertThat(listMock.size()).isEqualTo(1);
    }

    // configure mock method call with custom Answer
    @Test
    public void configureCustomAnswer() {
        MyList listMock = Mockito.mock(MyList.class);
        doAnswer(invocation -> "Always the same").when(listMock).get(anyInt());

        String element = listMock.get(1);
        assertThat(element).isEqualTo("Always the same");
    }

}

class MyList extends AbstractList<String> {
    @Override
    public String get(final int index) {
        return null;
    }
    @Override
    public int size() {
        return 1;
    }
}
