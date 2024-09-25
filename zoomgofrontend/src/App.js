
import Main from './main'
import Login from './login'
import Regist from './regist'
// import findInfo from './findInfo'
import { BrowserRouter, Routes, Route } from 'react-router-dom'; 

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/main" element={<Main />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/regist' element={<Regist />} />
        <Route path='/Login' element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
