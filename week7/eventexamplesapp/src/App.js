import React, { Component } from 'react';
import './App.css';

// CurrencyConverter Component
class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euros: ''
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit = () => {
    const euros = (parseFloat(this.state.rupees) * 0.011).toFixed(2);
    this.setState({ euros });
  }

  render() {
    return (
      <div style={{ marginTop: '30px' }}>
        <h3>Currency Converter</h3>
        <input
          type="number"
          placeholder="Enter amount in ₹"
          value={this.state.rupees}
          onChange={this.handleChange}
        />
        <button onClick={this.handleSubmit}>Convert</button>
        <p>€ Euro: {this.state.euros}</p>
      </div>
    );
  }
}

// Main App Component
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  // Function to increment
  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello(); // invoke another method
  }

  // Function to decrement
  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  }

  sayHello = () => {
    console.log('Hello! This is a static message.');
  }

  sayWelcome = (msg) => {
    alert(msg);
  }

  handleClick = (e) => {
    alert('I was clicked (Synthetic Event)');
    console.log(e); // Synthetic Event object
  }

  render() {
    return (
      <div className="App">
        <h2>React Event Handling Examples</h2>

        {/* Counter Buttons */}
        <h3>Counter: {this.state.count}</h3>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <hr />

        {/* Welcome Message Button */}
        <button onClick={() => this.sayWelcome('Welcome! React Event Received')}>
          Say Welcome
        </button>

        <hr />

        {/* Synthetic Event */}
        <button onClick={this.handleClick}>OnPress</button>

        <hr />

        {/* Currency Converter Component */}
        <CurrencyConverter />
      </div>
    );
  }
}

export default App;
