package nl.novi.testjunitjupiter.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.AbstractList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DemoMocks {

    public void setup() {
    }

    // configure simple return behavior for mock
    @Test
    public void simpleReturnBehaviour() {
        // given
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(false);

        // when
        boolean added = listMock.add("abc");

        // then
        assertFalse(added);
    }

    // configure return behavior for mock in an alternative way
    @Test
    public void alternativeReturnBehaviour() {
        MyList listMock = Mockito.mock(MyList.class);
        doReturn(false).when(listMock).add(anyString());

        boolean added = listMock.add("abc");
        assertFalse(added);
    }

    // configure mock to throw an exception on a method call
    @Test
    public void givenMethodIsConfiguredToThrowException_whenCallingMethod_thenExceptionIsThrown() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> { listMock.add("abc"); });
    }

    // configure the behavior of a method with void return type – to throw an exception
    @Test
    public void configureReturnVoid() {
        MyList listMock = Mockito.mock(MyList.class);
        doThrow(NullPointerException.class).when(listMock).clear();

        assertThrows(NullPointerException.class, () -> { listMock.clear(); });
    }

    // configure the behavior of multiple calls
    @Test
    public void configureMultipleCalls() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> {
            listMock.add("abc");
            listMock.add("abc"); // will throw the exception
        });

    }

    // configure the behavior of a spy
    @Test
    public void configureSpy() {
        MyList instance = new MyList();
        MyList spy = Mockito.spy(instance);

        doThrow(NullPointerException.class).when(spy).size();

        assertThrows(NullPointerException.class, () -> {
            spy.size(); // will throw the exception
        });
    }

    // configure method to call the real, underlying method on a mock
    @Test
    public void configureCallUnderlying() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.size()).thenCallRealMethod();

        assertEquals(1, listMock.size());
    }

    // configure mock method call with custom Answer
    @Test
    public void configureCustomAnswer() {
        MyList listMock = Mockito.mock(MyList.class);
        doAnswer(invocation -> "Always the same").when(listMock).get(anyInt());

        String element = listMock.get(1);
        assertEquals("Always the same", element);
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
