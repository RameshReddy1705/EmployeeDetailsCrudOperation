import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createEmployee, updateEmployee } from "./ServiceApi";

function CreateEmployee() {

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateEmployee = (e) => {
        e.preventDefault();

        const employee = {firstName, lastName, email}

        console.log(employee);
        if(id){
            updateEmployee(id, employee).then((response) => {
                navigate('/employees')
            }).catch(error => {
                console.log(error)
            })

        }else{
            createEmployee(employee).then((response) =>{

                console.log(response.data)
    
                navigate('/employees');
    
            }).catch(error => {
                console.log(error)
            })
        }
        
    }
    useEffect(() => {

        if(id){
            getEmployeeById(id).then((response) =>{
                setFirstName(response.data.firstName)
                setLastName(response.data.lastName)
                setEmail(response.data.email)
            }).catch(error => {
                console.log(error)
            })
        }

    }, [id])
    const pageTitle = () => {

        if(id){
            return <h2 className = "text-center">Update Employee</h2>
        }else{
            return <h2 className = "text-center">Add Employee</h2>
        }
    }


    return (
      <div className="container">
            <div className="row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        {
                           pageTitle()
                        }
                        <div className = "card-body">
                            <form>
                                <div  className = "form-group mb-2">
                                    <label  className = "form-label">First Name</label>
                                    <input
                                        type="text"
                                        placeholder = "Enter first name"
                                        name = "firstName"
                                        className = "form-control"
                                        value = {firstName}
                                        onChange = {(e) => setFirstName(e.target.value)}
                                    />
                                </div>
                                <div  className = "form-group mb-2">
                                    <label  className = "form-label">Last Name</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter last name"
                                        name = "lastName"
                                        className = "form-control"
                                        value = {lastName}
                                        onChange = {(e) => setLastName(e.target.value)}
                                    />
                                </div>
                                <div  className = "form-group mb-2">
                                    <label  className = "form-label">Email Id</label>
                                    <input
                                         type = "email"
                                         placeholder = "Enter email Id"
                                         name = "email"
                                         className = "form-control"
                                         value = {email}
                                         onChange = {(e) => setEmail(e.target.value)}
                                    />
                                </div>
                                <button className = "btn btn-success" onClick = {(e) => saveOrUpdateEmployee(e)} >Submit </button>
                            </form>
                        </div>
                    </div>
            </div>
      </div>
    );
  }
  
  export default CreateEmployee;
  