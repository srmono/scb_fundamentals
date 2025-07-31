class Employee {
    constructor(empId, empName){
        this.id = empId;
        this.name = empName
    }

    getEmpId() {console.log(this.id);}
    getEmpName() { console.log(this.name);}
}

var emp1 = new Employee(18, "Venkat"); // 100 properties

// emp1.getEmpId()
// emp1.getEmpName()

console.log(emp1);

// emp1.id
// emp1.name

const {id, name} = emp1;

console.log(id);
console.log(name);