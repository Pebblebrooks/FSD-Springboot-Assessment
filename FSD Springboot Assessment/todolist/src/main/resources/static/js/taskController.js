//development APIs
const addAPI= 'http://localhost:8080/task/add';
const displayAPI = 'http://localhost:8080/task/all';

let taskController = [];

function displayTask()
{
      //fetch data from database using the REST API endpoint from Spring Boot
      fetch(displayAPI)
          .then((resp) => resp.json())
          .then(function(data) {
              console.log("2. receive data")
             // console.log(data);

              data.forEach(function (task) {
                  const taskObj = {
                      id: task.id,
                      title: task.title,
                      description: task.description,
                      date:task.date
                 };
                   //This array consist of 3 objects
                  taskController.push(taskObj);
            });
           //Display all objects from the taskController array
            renderTaskPage();
          })
          .catch(function(error) {
              console.log(error);
          });
}

//(3)  Display all tasks when user launch the taskList.html page
function renderTaskPage() {

let display = `<tr>
<th>Title</th>
<th>Description</th>
<th>Target Date</th>
</tr>`;

for (let i = 0; i < taskController.length; i++ ) {

display += `
<tr>
<td>${taskController[i].title}</td>
<td>${taskController[i].description}</td>
<td>${taskController[i].date}</td>
</tr>`
}

document.querySelector(".table").innerHTML= display;

} //End of renderTaskPage function


function addTask(title,description,date)
{
  const formData = new FormData();
  formData.append('title', title);
  formData.append('description', description);
  formData.append('date', date);

  fetch(addAPI, {
    method: 'POST',
    body: formData
  })
  .then(function(response) {
    if (response.ok) {
      alert("Successfully Added Task!")
      // Add the new tasks to the taskController array
      const newTask = {
        id: response.id, // Use the id returned by the API
        title: title,
        description: description,
        date: date
      };
      taskController.push(newTask);
      // Re-render the TODO list
      renderTaskPage();
      // Close the modal
      const modal = document.getElementById('addFormModal');
      modal.style.display = "none";
    } else {
      alert("Something went wrong. Please try again")
    }
  })
  .catch((error) => {
    console.error('Error:', error);
    alert("Error adding task")
  });
}






