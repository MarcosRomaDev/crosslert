fetch("http://localhost:8080/hola")
  .then((response) => response.text())
  .then((texto) => {
    const hola = document.getElementById("hola");
    hola.textContent = texto;
  });
