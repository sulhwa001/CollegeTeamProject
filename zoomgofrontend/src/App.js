import './App.css';
import './index.css';
import BoardList from './Board/Board_List.js';
import InputText from './Board/Input.js';
import { BrowserRouter, Routes } from 'react-router-dom';
import { Route } from 'react-router-dom';
import Detail from './Board/Detail.js';
import Recommand from './review/Recommand_modal.js';
import GosuReview from './review/Gosu_review.js';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/boardlist" element={<BoardList/>}/>
          <Route path='/write' element={<InputText/>}/>
          <Route path='/detail' element={<Detail/>}/>
          <Route path='/recommand' element={<Recommand/>}/>
          <Route path='/gosu_review' element={<GosuReview/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
