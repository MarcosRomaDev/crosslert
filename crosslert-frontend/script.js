const tickerForm = document.getElementById("ticker-form");
const tickerInput = document.getElementById("ticker");
const tickerSearchResult = document.getElementById("result");

tickerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const urlTickerSearch =
    "http://localhost:8080/api/search/" + tickerInput.value;
  fetch(urlTickerSearch)
    .then((Response) => Response.json())
    .then((data) => {
      tickerSearchResult.textContent = "";
      data.forEach((item) => {
        let symbol = item.symbol;
        let name = item.name;
        let node = document.createElement("li");
        node.textContent = symbol + " - " + name;
        tickerSearchResult.appendChild(node);
      });
    });
});
