import React from "react";

const BlogDetails = () => {
  const blogs = [
    {
      heading: "React Tips",
      author: "Amit Sharma",
      description: "Simple tricks to make React easier!",
    },
    {
      heading: "Node Deployment",
      author: "Neha R",
      description: "How to deploy Node apps on render and vercel.",
    },
  ];

  return (
    <div className="column">
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <div key={index}>
          <strong>{blog.heading}</strong>
          <br />
          <em>{blog.author}</em>
          <br />
          {blog.description}
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
