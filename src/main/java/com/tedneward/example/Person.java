package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int count;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    count++;
  }

  public int getAge() {
    return age;
  }
  
  public void setAge(int age) { 
    if (age < 0) {
      throw new IllegalArgumentException();
    }
    this.age = age;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }
  
  public double getSalary() {
    return salary;
  }
  
  public void setSalary(double salary) {
    this.salary = salary;
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
  
  public void setPropertyChangeFired(boolean propertyChangeFired) {
    this.propertyChangeFired = propertyChangeFired;
  }

  public int count() {
    return count;
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
  
  public boolean equals(Person other) {
    if (other instanceof Person) {
      Person otherPerson = (Person)other;
      if (otherPerson.name != null && this.name != null) {
        return (this.name.equals(other.name) && this.age == other.age);
      }
    }
    return false;
  }
  
  public int compareTo(Person other) {
    double salaryDifference = other.salary - salary;
    
    if (salaryDifference < 0) {
      return -1;
    } else {
      return 1;
    }
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
      return person1.age - person2.age;
    }
  }
  
  public static ArrayList<Person> getNewardFamily() {
    return new ArrayList<Person>() {{
      add(new Person("Matthew", 15, 0));
      add(new Person("Michael", 22, 10000));
      add(new Person("Ted", 41, 250000));
      add(new Person("Charlotte", 43, 150000));
    }};
  }
  
  public String toString() {
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
