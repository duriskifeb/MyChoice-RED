package Data.DataSource;

import Data.Model.Customer;
import Data.Model.CustomerRumah;

import static View.AppRouter.AppRoute.EXIT;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerRumahSource {
    private ArrayList<CustomerRumah> listCustomer = new ArrayList<>(
        Arrays.asList(
            new CustomerRumahSource(
                "1201230037",
                "Ahmad",
                "ahmad@gmail.com",
                "08123456789"
            ),
            new CustomerRumahSource(
                "1201230038",
                "Budi",
                "budi@gmail.com",
                "08987654321"
            )
    )
}