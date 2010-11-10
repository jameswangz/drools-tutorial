[condition][]There is a Customer with firstName {name}=$customer : Customer(firstName == {name})
[consequence][]Greet Customer=System.out.println("Hello " + $customer.getFirstName());
[consequence][]Set Greeted=$customer.setGreeted(true);
