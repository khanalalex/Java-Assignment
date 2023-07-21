document.addEventListener("DOMContentLoaded", function () {
  // Get the current date and time
  const now = new Date();
  const currentDate = now.toDateString();
  const currentTime = now.toLocaleTimeString();

  // Display the current date and time in the container
  const currentDateTime = document.getElementById("current-date-time");
  currentDateTime.textContent = `Current Date: ${currentDate} | Current Time: ${currentTime}`;
});
