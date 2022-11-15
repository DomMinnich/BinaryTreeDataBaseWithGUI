public class Employee {
    String EmployeeID; // Employee ID
    String FirstName; // First Name
    String LastName; // Last Name
    String Position; // Position
    String Site; // Site
    Boolean fired = false; // Not Fired By Default

    //the employees id will be the first letter of the site, then a "-" then the first 3letters of their first name then the first letter of their last name then a "-" then a 2 digit number representing how many of the same employee id there are
    //ex: EmployeeID = "M-ABCA-01"
    //ex: EmployeeID = "M-ABCA-02"

    public Employee(String EmployeeID, String FirstName, String LastName, String Position, String Site, Boolean fired) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Position = Position;
        this.Site = Site;
        this.fired = fired;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    // fired getter and setter

    public Boolean getFired() {
        return fired;
    }

    public void setFired(Boolean fired) {
        this.fired = fired;
    }
    

    public String toString() {
        return EmployeeID + " " + FirstName + " " + LastName + " " + Position + " " + Site;
    }

    public boolean equals(Employee other) {
        return this.EmployeeID.equals(other.EmployeeID);
    }

    public int compareTo(Employee other) {
        return this.EmployeeID.compareTo(other.EmployeeID);
    }

}