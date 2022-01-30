package com.sda.javaee9spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void dependencyInjectionFirstTrial () {
        Toy plasticGun = new Toy("plastic gun");
        Child john = new Child("John", plasticGun);
        // dependency injection is providing all required class dependencies during creations of objects of that class
        // plasticGun (of type Toy) is dependency of john (of type Child)
        // john (which is of type Child) is dependency of jason (of type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);
    }

    @Test
    void recordTest() {
        Animal animal = new Animal();
        System.out.println(animal);

        // use records instead of @Value from Lombok
        // records are immutable - cannot modify instances of the class - so setters
        Toy plasticGun = new Toy ("plastic gun");
        System.out.println(plasticGun);

        // child.with(favouriteToy = plasticGun); // in future Java versions
    }

  @Test
  void equalsTest() {
      Assertions.assertTrue(4 == 4);

      Animal one = new Animal();
      Animal two = new Animal();
      Animal three = one;

      // == it checks if this is the same objects
      // equals by default it checks if this is the same objects
      Assertions.assertFalse(one == two);
      Assertions.assertFalse(one.equals(two));

      Toy plasticGun = new Toy("plastic gun");
      Toy plasticGun2 = new Toy("plastic gun");
      Assertions.assertEquals(plasticGun, plasticGun2);
  }
}

// Toy is made of name
record Toy(String name) {}
// child is compose of: name and toy
record Child(String name, Toy favouriteToy) {}
// parent is made of/compose of: name and child
record Parent(String name, Child child) {
}


class Animal {}
class Mammal extends Animal {}
class Tiger extends Mammal {}
// Tiger is Mammal
// Tiger is Animal
// We cannot say: Parent is Child (Parent don't extend Child)

