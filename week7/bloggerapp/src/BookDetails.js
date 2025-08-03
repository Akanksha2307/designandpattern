import React from "react";

const BookDetails = () => {
  const books = [
    { title: "Learn JavaScript", price: 499 },
    { title: "Mastering React", price: 799 },
    { title: "Node.js Basics", price: 599 },
  ];

  return (
    <div className="column">
      <h2>Book Details</h2>
      {books.map((book, index) => (
        <div key={index}>
          <strong>{book.title}</strong>
          <br />
          {book.price}
        </div>
      ))}
    </div>
  );
};

export default BookDetails;
