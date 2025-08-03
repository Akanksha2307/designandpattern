import React from "react";

const CourseDetails = () => {
  const courses = [
    { name: "JavaScript", date: "10/12/2021" },
    { name: "TypeScript", date: "2/5/2022" },
  ];

  return (
    <div className="column">
      <h2>Course Details</h2>
      {courses.map((course, index) => (
        <div key={index}>
          <strong>{course.name}</strong>
          <br />
          {course.date}
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
