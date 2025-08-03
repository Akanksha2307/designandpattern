import React from 'react';
import './App.css';

// Step 1: Import all images
import office1Img from './images/office1.png';
import office2Img from './images/office2.png';
import office3Img from './images/office3.png';
import office4Img from './images/office4.png';

function App() {
  const office1 = {
    name: 'Regus Office Space',
    rent: 55000,
    address: '5th Floor, Tech Park, Bangalore',
    image: office1Img
  };

  const offices = [
    {
      name: 'WeWork Indiranagar',
      rent: 75000,
      address: 'Indiranagar, Bangalore',
      image: office2Img
    },
    {
      name: 'CoWrks Ecoworld',
      rent: 58000,
      address: 'Outer Ring Road, Bangalore',
      image: office3Img
    },
    {
      name: '91Springboard',
      rent: 62000,
      address: 'HSR Layout, Bangalore',
      image: office4Img
    }
  ];

  return (
    <div className="App">
      <h1>Office Space Rental App</h1>

      {/* Display first office */}
      <div style={{ border: '1px solid black', padding: '10px', marginBottom: '20px' }}>
        <h2>{office1.name}</h2>
        <img src={office1.image} alt={office1.name} width="300" height="200" />
        <p><strong>Rent:</strong> <span style={{ color: office1.rent < 60000 ? 'red' : 'green' }}>{office1.rent}</span></p>
        <p><strong>Address:</strong> {office1.address}</p>
      </div>

      {/* Display other offices */}
      {offices.map((office, index) => (
        <div key={index} style={{ border: '1px solid grey', padding: '10px', marginBottom: '20px' }}>
          <h2>{office.name}</h2>
          <img src={office.image} alt={office.name} width="300" height="200" />
          <p><strong>Rent:</strong> <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>{office.rent}</span></p>
          <p><strong>Address:</strong> {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
