Employee emp1=new Employee();
    Employee emp2=new Employee();

    emp1.fullName="Java";
    emp1.salary=10000.0f;

    emp2.fullName="Pyton";
    emp2.salary=100.0f;

    Employee[]employees={emp1,emp2};

    String employeesInfo="[";

    for(int i=0;i<employees.length;i++){
    if(i>0){
    employeesInfo+=", ";
    }
    employeesInfo+=
    "{fullName: \""+employees[i].fullName+"\", salary: "+employees[i].salary+"}";

    }
    employeesInfo+="]";
