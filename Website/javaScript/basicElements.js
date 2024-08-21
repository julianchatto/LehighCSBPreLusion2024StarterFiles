window.onload = () => {
    const form = document.getElementById("form")
    form.addEventListener('submit', submitForm)
    
    htmlButton = document.getElementById("filterHtml")
    htmlButton.addEventListener('change', filterHtmlCotext)

    if(!hash.html){
      htmlButton.click()
    }

    htmlButton.click()

    cssButton = document.getElementById("filterCss")
    cssButton.addEventListener('change', filterHtmlCotext)

    if(!hash.css){
      cssButton.click()
    }

    cssButton.click()

    javascriptButton = document.getElementById("filterJavascript")
    javascriptButton.addEventListener('change', filterHtmlCotext)

    if(!hash.javascript){
      javascriptButton.click()
    }

    javascriptButton.click()

    if(!hash.javascript && !hash.css && !hash.html){
      javascriptButton.click()
      cssButton.click()
      htmlButton.click()
    }


    const canvas = document.getElementById("canvas")
    const canvasContext = canvas.getContext("2d")
    const image = document.getElementById("csbImage")
    
    canvasContext.drawImage(image, 0, 0)
    canvasContext.fillStyle="white"
    canvasContext.fillRect(15, 25, 70, 50)
    canvasContext.font = "30px Arial"
    canvasContext.fillStyle="red"
    canvasContext.fillText("CSB", 20, 60)
}

let htmlButton

onlyHtml = () => {
  if(!htmlButton.checked) htmlButton.click()
  if(cssButton.checked) cssButton.click()
  if(javascriptButton.checked) javascriptButton.click()
}

let cssButton

onlyCss = () => {
  if(htmlButton.checked) htmlButton.click()
  if(!cssButton.checked) cssButton.click()
  if(javascriptButton.checked) javascriptButton.click()
}

let javascriptButton

onlyJavascript = () => {
  if(htmlButton.checked) htmlButton.click()
  if(cssButton.checked) cssButton.click()
  if(!javascriptButton.checked) javascriptButton.click()
}

const initialHash = window.location.hash.replace('#', '').split(',')
let hash = {'html': initialHash.indexOf('html') != -1, 'css': initialHash.indexOf('css') != -1, 'javascript': initialHash.indexOf('javascript') != -1}

setNewHash = () => {
  let newHash = "#"
  for (let hashKey of Object.keys(hash)){
    if(hash[hashKey]){
      newHash += hashKey + ","
    }
  }
  window.location.hash = newHash
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

filterHtmlCotext = (event) => {
  const checkBox = event.srcElement
  if (checkBox.checked){
    hash[checkBox.value] = true
    setNewHash()
  }else{
    hash[checkBox.value] = false
    setNewHash()
  }
  filterHtml(event)
}

filterHtml = (event) => {
  const checkBox = event.srcElement
  const visibilityValue = checkBox.checked ? {visibility: "visible", opacity: 1, display: "flex"} : {visibility: "hidden", opacity: 0, display: "none"}
  if(checkBox.checked){
    checkBox.parentElement.style.backgroundColor = checkBox.getAttribute("color")
    checkBox.parentElement.style.color = "white"
  }else {
    checkBox.parentElement.style.backgroundColor = "white"
    checkBox.parentElement.style.color = checkBox.getAttribute("color")
  }
  const htmlElements = document.getElementsByClassName(checkBox.value)

  for(const htmlElement of htmlElements){
    htmlElement.style.opacity = visibilityValue.opacity
    htmlElement.style.visibility = visibilityValue.visibility
    htmlElement.style.display = visibilityValue.display
  }
}