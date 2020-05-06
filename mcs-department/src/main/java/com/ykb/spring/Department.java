package com.ykb.spring;

public class Department {

    private String name;
    private int    employeeCount;
    private int    createYear;
    private int    createMonth;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(final int employeeCountParam) {
        this.employeeCount = employeeCountParam;
    }

    public int getCreateYear() {
        return this.createYear;
    }

    public void setCreateYear(final int createYearParam) {
        this.createYear = createYearParam;
    }

    public int getCreateMonth() {
        return this.createMonth;
    }

    public void setCreateMonth(final int createMonthParam) {
        this.createMonth = createMonthParam;
    }

    @Override
    public String toString() {
        return "Department [name="
               + this.name
               + ", employeeCount="
               + this.employeeCount
               + ", createYear="
               + this.createYear
               + ", createMonth="
               + this.createMonth
               + "]";
    }


}
