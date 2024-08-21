window.onload = () => {
    slideShowElements = document.getElementsByClassName("slideShowElement")
    console.log(currentSlide)
    changeSlides(currentSlide)
    
    const leftDirectionButton = document.getElementById("left")
    leftDirectionButton.addEventListener("click", leftSlide)
    const rightDirectionButton = document.getElementById("right")
    rightDirectionButton.addEventListener("click", rightSlide)
}

let slideShowElements
let currentSlide = 0

leftSlide = () => {
    let slideTo = (currentSlide - 1) % slideShowElements.length
    if(slideTo == -1) slideTo = slideShowElements.length - 1
    console.log(slideTo)
    slideShowElements[slideTo].style.animationName = "leftShift"
    changeSlides(slideTo)
}
rightSlide = () => {
    let slideTo = (currentSlide + 1) % slideShowElements.length
    slideShowElements[slideTo].style.animationName = "rightShift"
    changeSlides(slideTo)
}

changeSlides = (slide) => {
    Array.from(slideShowElements).forEach(element => {
        element.style.display = "none"
    });

    slideShowElements.item(slide).style.display = "inherit"
    currentSlide = slide
}