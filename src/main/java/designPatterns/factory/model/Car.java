package designPatterns.factory.model;

public class Car {

  private String name;
  private String model;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void makeCar(){
    System.out.println(name + " is prepared with  "+model+ " model");
  }
}
