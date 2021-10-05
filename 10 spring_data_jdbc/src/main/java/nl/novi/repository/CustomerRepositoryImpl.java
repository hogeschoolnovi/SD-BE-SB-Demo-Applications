package nl.novi.repository;

import nl.novi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    // Spring Boot will create and configure DataSource and JdbcTemplate
    // To use it, just @Autowired
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from customers", Integer.class);
    }

    @Override
    public int save(Customer customer) {
        return jdbcTemplate.update(
                "insert into customers (id, first_name, last_name) values (?, ?, ?)",
                customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update(
                "update customers set first_name = ?, last_name = ? where id = ?",
                customer.getFirstName(), customer.getLastName(), customer.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from customers where id = ?",
                id);
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "select * from customers",
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name")
                        )
        );
    }

    // jdbcTemplate.queryForObject, populates a single object
    @Override
    public Optional<Customer> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from customers where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Customer(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name")
                        ))
        );
    }

    @Override
    public List<Customer> findByLastName(String name) {
        return jdbcTemplate.query(
                "select * from customers where name like ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name")
                        )
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from customers where id = ?",
                new Object[]{id},
                String.class
        );
    }

    @Override
    public Boolean existsById(Long id) {
        return jdbcTemplate.query(
                "select 1 from customers where id = ?",
                new Object[]{id},
                (rs) -> {
                    if (rs.next()) {
                        return true;
                    }
                    return false;
                });
    }

}