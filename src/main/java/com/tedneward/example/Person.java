package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int count;

/*Make Person be Comparable, such that when I compare two Persons, they arrange themselves by
salary in reverse order (salary 150000 is less than salary 10000). (Rich people to the front!)*/

  public int compareTo(Person other) {
    double salaryDifference = other.salary - salary;
    
    if (salaryDifference < 0) {
      return -1;
    } else if (salaryDifference > 0) {
      return 1;
    } else {
      return 0;
    }
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
      return person1.age - person2.age;
    }
  }
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    count++;
  }

  public int getAge() { return age; }
  public void setAge(int age) { 
    if (age < 0) {
      throw new IllegalArgumentException();
    }
    this.age = age;
  }
  
  public String getName() { return name; }
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }
  
  public double getSalary() { return salary; }
  public void setSalary(double salary) { this.salary = salary; }
  
  public String getSSN() { return ssn; }
  public void setSSN(String ssn) { this.ssn = ssn; }
  
  public boolean getPropertyChangeFired() { return propertyChangeFired; }
  public void setPropertyChangeFired(boolean propertyChangeFired) { this.propertyChangeFired = propertyChangeFired; }

  public int count() {
    return count;
  }
  
  public int getAge() {
    return age;
  }
  
  public String getName() {
    return name;
  }
  
  public double getSalary() {
    return salary;
  }
  
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  /*Ensure that Person.equals() returns true if two Person instances have the same name
  and age (salary doesn't factor into equality comparison). Make sure no exceptions are
  thrown from this method--anything "weird" should just return false.*/
  public boolean equals(Person other) {
    return (this.name.equals(other.name) && this.age = other.age)
  }

  public String tostring() {
    return "{{FIXME}}";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
