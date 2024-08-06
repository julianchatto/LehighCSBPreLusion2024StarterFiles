window.onload = () => {
    const form = document.getElementById("form")
    form.addEventListener('submit', submitForm)
    
    const htmlButton = document.getElementById("filterHtml")
    htmlButton.addEventListener('change', filterHtml)

    const cssButton = document.getElementById("filterCss")
    cssButton.addEventListener('change', filterHtml)

    const javascriptButton = document.getElementById("filterJavascript")
    javascriptButton.addEventListener('change', filterHtml)

    const canvas = document.getElementById("canvas")
    const canvasContext = canvas.getContext("2d")
    const image = document.getElementById("csbImage")
    
    console.log("go")
    canvasContext.drawImage(image, 0, 0)
    canvasContext.fillStyle="white"
    canvasContext.fillRect(15, 25, 70, 50)
    canvasContext.font = "30px Arial"
    canvasContext.fillStyle="red"
    canvasContext.fillText("CSB", 20, 60)
}

submitForm = (event) => {
    event.preventDefault()
    const formData = new FormData(form)

    const output = document.getElementById("output")
    output.textContent = ""

    for (const [key, value] of formData) {
      output.textContent += `${key}: ${value}\n`
    }
}

filterHtml = (event) => {
  const visibilityValue = event.srcElement.checked ? {visibility: "visible", opacity: 1} : {visibility: "hidden", opacity: 0}
  if(visibilityValue.opacity){
    event.srcElement.parentElement.className = "checked"
  }else {
    event.srcElement.parentElement.className = null
  }
  const htmlElements = document.getElementsByClassName(event.srcElement.value)

  for(const htmlElement of htmlElements){
    htmlElement.style.opacity = visibilityValue.opacity
    htmlElement.style.visibility = visibilityValue.visibility
  }
}