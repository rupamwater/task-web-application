import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/project";

export const listProjects = () => {
    console.log("test");
    return axios.get(REST_API_BASE_URL);
} 
