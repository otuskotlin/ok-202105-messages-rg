import './App.css';
import React from 'react';
import ReactDOM from 'react-dom';
function App() {
  return (
    <div className="App">
      <header className="App-header">
          <div className="messages">
              Здесь будут сообщения, которые мы читаем от тех-поддержки
          </div>
          <form action="">
              <label>
                  send:
                  <input type="text" name="payload" />
              </label>
              <input type="submit" value="Отправить" />
          </form>
      </header>
    </div>
  );
}

export default App;
