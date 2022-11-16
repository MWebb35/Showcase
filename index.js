const state = {
  numCells: (600 / 40) * (600 / 40),
  cells: [],
  shipPosition: 217,
  alienPositions: [
    3, 4, 5, 6, 7, 8, 9, 10,11,
    18,19,20,21,22,23,24,25,26,
    33,34,35,36,37,38,39,40,41,
    48,49,50,51,52,53,54,55,56
  ],
gameover: false,
score: 0,
}

const setupGame = (element) => {
  state.element = element
  //do all things needed to draw the game
  
  //draw grid
  drawGrid()
  //draw spaceship
  drawSpaceship()
  //draw aliens
  drawAliens()
  //add instructions and score
  drawScoreboard()
}

const drawGrid = () => {
  //create containing element

  const grid = document.createElement('div')
  grid.classList.add('grid')

  //insert grid into the app
  state.element.append(grid)
  
  //create a lot of cells - 15x15 (225)
  for (let i = 0; i<state.numCells; i++){
    //create a cell 
    const cell = document.createElement('div')
    state.cells.push(cell)
    //append a cell to the grid
    grid.append(cell)
  }
  
  //append the cells to the containing element and the containing element to the app
  
  
}

const drawSpaceship = () => {
  //find the bottom row, middle cell (from game state), add a bg image
  state.cells[state.shipPosition].classList.add('spaceship')
}

const controlShip = (event) => {
  console.log(event)
  
  if (state.gameover) return

  if(event.code === 'ArrowLeft'){
    moveShip('left')
  }else if (event.code === 'ArrowRight'){
    moveShip('right')
  }else if (event.code === 'Space'){
    fire()
  }
}

const drawAliens = () => {
  // loop through cells, remove, and add class name to corresponding cell.
  state.cells.forEach((cell, index) => {
    // reset: if cell index is currently an alien position remove it
    if (cell.classList.contains('alien')) {
      cell.classList.remove('alien')
    }
    // update: if cell index is an alien position, add alien class
    if (state.alienPositions.includes(index)) {
      cell.classList.add('alien')
    }
  })
}

const moveShip = (direction) => {
  //remove image from current pos
  state.cells[state.shipPosition].classList.remove('spaceship')
  //figure out the delta
  if (direction === 'left' && state.shipPosition % 15 !== 0){
    state.shipPosition--
  }else if(direction === 'right' && state.shipPosition % 15 !== 14){
    state.shipPosition++
  }
  //add image to new pos
  state.cells[state.shipPosition].classList.add('spaceship')
}

const fire = () => {
  //use an interval: run some code repeatedly each time afyer a specified time 
  let interval
    //laser starts at ship position 
  let laserPosition = state.shipPosition
  
  interval = setInterval(() => {
    //remove the laster image
    state.cells[laserPosition].classList.remove('laser')
    //decrease (move up a row) the laser position 
    laserPosition-=15
    //check we are still in bounds
    if (laserPosition < 0) {
      clearInterval(interval)
      return
    }

    //if theres an alien BOOM!
    //clear the interval, remove the alien image, remove the alien from the alien position , add the BOOM image, set a time out for the BOOM image

    if(state.alienPositions.includes(laserPosition)) {
      clearInterval(interval)
        state.alienPositions.splice(state.alienPositions.indexOf(laserPosition), 1)
      state.cells[laserPosition].classList.remove('alien', 'laser')
      state.cells[laserPosition].classList.add('hit')
      state.score++
      state.scoreElement.innerText = state.score
      
      setTimeout(() => {
      state.cells[laserPosition].classList.remove('hit')
      }, 200)
      return
    }
    //add the laser image 
    state.cells[laserPosition].classList.add('laser')
  }, 100)
}

const atEdge = (side) => {
  if (side === 'left'){
    //any aliens in the left hand column?
    return state.alienPositions.some(position => position % 15 === 0)
  } else if (side=== 'right') {
    //any aliens in right hand column?
    return state.alienPositions.some(position => position % 15 === 14)
  }
}

const play = () => {
  //alien invasion!
  let interval 
  //starting direction
  let direction = 'right'
  interval = setInterval(() => {
    let movement
    
    if (direction === 'right'){
      if (atEdge('right')){
        //if right and at edge, + 15 and move left, decrease by 1
        movement=15-1
        direction = 'left'
      }else {
        movement = 1
        //if right increase the pos by 1
        //continue moving right, pos by 1
      }  
    }else if (direction === 'left'){
      // if left, decrease by 1,
      if (atEdge('left')){
        movement=15+1
        direction = 'right'
        // if left and at edge increase pos by 15, increase by 1
      }else {
        movement = -1
        //continue moving right, pos by 1
      }
    }
    
     
    
    //update alien pos
    state.alienPositions = state.alienPositions.map(position => position + movement)
    //redraw aliens
    drawAliens()

    checkGameState(interval)
  }, 400)
  
  //set up ship controls
  window.addEventListener('keydown', controlShip)
}

const checkGameState = (interval) => {
  //have the aliens got to the bottom?
  //have all the aliens been eliminated?
  if (state.alienPositions.length === 0){
    clearInterval(interval)
    //stop eveything 
    state.gameover = true
    
    
    drawMessage ("HUMAN WINS")
  }else if (state.alienPositions.some(position => position >= state.shipPosition)){
    clearInterval(interval)
    //make ship go boom!
    //remove the ship image, add the explosion image 
    state.gameover = true 
    state.cells[state.shipPosition].classList.remove('spaceship')
    state.cells[state.shipPosition].classList.add('hit')
    drawMessage("GAME OVER")
  }
}

const drawMessage = (message) => {
  //create a message 
  const messageElement = document.createElement('div')
  messageElement.classList.add('message')
  //append it to the app
  

  const h1 = document.createElement('h1')
  h1.innerText = message
  messageElement.append(h1)

  state.element.append(messageElement)
}

const drawScoreboard = () => {
  const heading = document.createElement("h1")
  heading.innerText = 'Space Invaders'
  const paragraph1 = document.createElement("p")
  paragraph1.innerText = 'Press SPACE to shoot.'
  const paragraph2 = document.createElement("p")
  paragraph2.innerText = 'Press ← and → to move'
  const scoreboard = document.createElement('div')
  scoreboard.classList.add('scoreboard')
  const scoreElement = document.createElement('span')
  scoreElement.innerText = state.score
  const heading3 = document.createElement('h3')
  heading3.innerText = 'Score: '
  heading3.append(scoreElement)
  scoreboard.append(heading, paragraph1, paragraph2, heading3)

  state.scoreElement = scoreElement
  state.element.append(scoreboard)
}
//query the page for the place to insert my game
const appElement = document.querySelector('.app')

//do all the things needed to draw the game
setupGame(appElement)
//play the game - start being able to move ship and aliens
play()