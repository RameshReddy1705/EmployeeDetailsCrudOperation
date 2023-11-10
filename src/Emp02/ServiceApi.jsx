import axios from "axios";


const apiClient=axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)

export const listEmployees
                =()=>apiClient.get('/emp02')

export const createEmployee
                =(employee)=>apiClient.post('/emp02',employee)

export const updateEmployee
                =(id,employee)=>apiClient.put(`/emp02/${id}`,employee)


export const deleteEmployee
                =(id,employee)=>apiClient.delete(`/emp02/${id}`,employee)

export const getEmployeeById
                =(id,employee)=>apiClient.get(`/emp02/${id}`,employee)



// const Base_Url='http://localhost:8080/api/v1/employees';

// export const listEmployees=()=>{
//     return axios.get(Base_Url)
// };

// export const createEmployee=(employee)=>{
//     return axios.post(Base_Url+'/'+employee)
// };

// export const updateEmployee=(employeeId,employee)=>{
//     return axios.put(Base_Url+'/'+employeeId,employee)
// };

// export const getEmployeeById=(employeeId)=>{
//     return axios.get(Base_Url+'/'+employeeId)
// };

// export const deleteEmployee=(employeeId)=>{
//     return axios.delete(Base_Url+'/'+employeeId)
// };