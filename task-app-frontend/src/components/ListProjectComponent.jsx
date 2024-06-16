import React, { useState , useEffect } from 'react'
import { listProjects } from '../services/ProjectService'

function ListProjectComponent() {

    const [ projects, setProjects ] = useState([]);

    useEffect(() => {
        listProjects()
          .then((response) => {
            setProjects(response.data);
          })
          .catch((error) => {
            console.log(error);
          } )
    } );


  const dummyData = [
    {
        "id" : 1,
        "name" : "Project 1",
        "description" : "Project Description 1",
        "type" : "Type 1"
    },
    {
        "id" : 2,
        "name" : "Project 2",
        "description" : "Project Description 2",
        "type" : "Type 1"
    },
    {
        "id" : 3,
        "name" : "Project 3",
        "description" : "Project Description 3",
        "type" : "Type 2"
    }
]  

  return (
    <div>
        <h1>List of Projects </h1>
        <table className='table table-striped table-bordered' >
            <thead>
                <tr>
                    <th>Project ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                {
                    projects.map(project => 
                       
                        <tr key={project.id}>
                               <td>{project.id}</td>
                               <td>{project.name}</td>
                               <td>{project.description}</td>     
                               <td>{project.type}</td> 
                        </tr>
                        
                        )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListProjectComponent