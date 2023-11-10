import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListEmployee02 from "./ListEmployee02";
import CreateEmployee from "./CreateEmployee";

function Main() {
    return (
      <div className="App">
       TT
        <BrowserRouter>
            <div>
                <Routes>
                <Route path="/" element={<ListEmployee02></ListEmployee02>}></Route>
                  {/* <Route path="/list" element={<ListEmployee02></ListEmployee02>}></Route> */}
                  <Route path="/employees" element={<ListEmployee02></ListEmployee02>}></Route>
                  <Route path="/add-employee" element={<CreateEmployee></CreateEmployee>}></Route>
                  <Route path="/edit-employee/:id" element={<CreateEmployee></CreateEmployee>}></Route>
                </Routes>
            </div>
        </BrowserRouter>
      </div>
    );
  }
  
  export default Main;