import { useEffect, useState } from "react";
import { retriveAll} from "./Api/EmployeeServiceApi";
import { Link, useNavigate } from "react-router-dom";
import { listEmployees } from "../Emp02/ServiceApi";

function ListEmployee() {
    const [employee, setEmployee] = useState([])
    const navigate=useNavigate()
    useEffect(
        ()=>refreshEmployee(),[]
    )
    function refreshEmployee()
    {
        listEmployees(1)
        .then(res=>{
            console.log(res);
        })
            
        .catch(error=>{
            console.log(error);
        })
    }function addemployee()
    {
        navigate('/createEmp')
    }

    return (
      <div className="App">
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employee.map(
                            employee=>(
                                <tr>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstname}</td>
                                    <td>{employee.lastname}</td>
                                    <td>{employee.email}</td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            </table>
            <button className="btn btn-success" onClick={addemployee}>Add Employee</button>
        </div>
      </div>
    );
  }
  
  export default ListEmployee;