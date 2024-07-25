import React, { useState, useEffect } from 'react';
 
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';


export default function StudentSave() {
  const[name,setName]=useState('')
  const[address,setAddress]=useState('')
  const[students,setStudents]=useState([])
  const paperStyle = {
    padding: '20px',
    margin: '20px',
    textAlign: 'center',
  };
  const handleSave=(e)=>{
    e.preventDefault()
    const student={name,address}
    console.log(student)
    fetch("http://localhost:8080/student/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("New Student added")
  })
}
useEffect(()=>{
  fetch("http://localhost:8080/student/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])
  return (
    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
        backgroundColor: 'white', // Set background color to white
        padding: 2, // Optional: Add some padding to the Box
        borderRadius: 1, // Optional: Add some border radius
        boxShadow: 1, // Optional: Add some box shadow for better visual appearance
      }}
      noValidate
      autoComplete="off"
    >
      <div>
      <h1 style={{color:"blue"}}><u>Add Student</u></h1>
        <TextField
          id="outlined-multiline-flexible"
          label="Name"
          placeholder="Name"
          multiline
          maxRows={4}
          fullWidth 
          value={name}
          onChange={(e)=>setName(e.target.value)}
        />
        <TextField
          id="outlined-textarea"
          label="Address"
          placeholder="Address"
          multiline
          fullWidth
          value={address}
          onChange={(e)=>setAddress(e.target.value)}
        />

           </div>
           <Button variant="contained" color="success" onClick={handleSave}>
  Save
</Button>
<h1>Students</h1>

<Paper elevation={3} style={paperStyle}>

  {students.map(student=>(
    <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
     Id:{student.id}<br/>
     Name:{student.name}<br/>
     Address:{student.address}

    </Paper>
  ))
}
</Paper>
    </Box>
    
  );

  
}