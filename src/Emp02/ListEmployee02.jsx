import { useEffect, useState } from "react";
import { deleteEmployee, listEmployees } from "./ServiceApi";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function ListEmployee02() {
     const [employee, setEmployee] = useState([])
     const navigate=useNavigate()
     useEffect(() => {
        getAllEmp();
    }, [])

    const getAllEmp=()=>{
         listEmployees()
        // axios.get('http://localhost:8080/emp02')
        .then((res)=>{
            console.log(res);
            setEmployee(res.data)
        })
        .catch(error=>{
            console.log(error);
        })
    }
    const removeEmployee = (employeeId) => {
        deleteEmployee(employeeId).then((response) =>{
            getAllEmp();
 
        }).catch(error =>{
            console.log(error);
        })
         
     }
     function addNewEmployee() {
        navigate('/add-employee')
    }
     const updateEmployee = (id) => {
        navigate(`/edit-employee/${id}`)
    }
    return (
        <div className="container">
            <h2 className = "text-center">List Employees</h2>
            <button className = "btn btn-primary mb-2" onClick={addNewEmployee }>Add Employee</button>
             <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employee.map(
                            employee=>(
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.email}</td>
                                    <td>
                                    <button className="btn btn-info" onClick={() => updateEmployee(employee.id)} >Update</button>
                                    <button className = "btn btn-danger" onClick = {() => removeEmployee(employee.id)}
                                    style = {{marginLeft:"10px"}}> Delete</button>
                                    </td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            </table>
        </div>
    );
  }
  
  export default ListEmployee02;