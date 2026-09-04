const tickerForm = document.getElementById("ticker-form");
const tickerInput = document.getElementById("ticker");
const tickerSearchResult = document.getElementById("result");
const chartCanvas = document.getElementById("chart");

// Busqueda de symbolos

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
        node.dataset.symbol = item.symbol;
        node.textContent = symbol + " - " + name;
        node.addEventListener("click", () => {
          let selected = node.dataset.symbol;
          console.log(selected);
          loadCandles(node.dataset.symbol);
        });
        tickerSearchResult.appendChild(node);
      });
    });
});

// Candle Fetch

function loadCandles(symbol) {
  fetch("http://localhost:8080/api/candles/" + symbol)
    .then((Response) => Response.json())
    .then((data) => {
      console.log(data);
      data.sort((a, b) => a.id.date.localeCompare(b.id.date));
      let date = data.map((candle) => candle.id.date);
      let close = data.map((candle) => candle.close);
      new Chart(chartCanvas, {
        type: "line",
        data: {
          labels: date,
          datasets: [{ label: "Close", data: close }],
        },
      });
    });
}
