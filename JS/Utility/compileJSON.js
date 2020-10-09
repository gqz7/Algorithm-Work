//This algorithm take a directory path and an object key. 
//The main purpose is to grab array data from many json files and compile the data into one array in a single JSON file.
const fs = require('fs');

const compileJson = ({path, fileName, key, start, limit, outFileName}) => {

  const finalArr = []

    for (let i = start; i <= limit; i++) {
      
      const filePath = `${path}${fileName}${i}.json`

      const raw = JSON.parse(fs.readFileSync(filePath));

      for (let i = 0; i < raw[key].length; i++) {
        const element = JSON.parse(raw[key][i]);
        finalArr.push( element )
      }
    }

    const 
      ofPath = `${__dirname}\\${outFileName}.json`,
      outFileData = JSON.stringify(finalArr);

    fs.writeFileSync( ofPath, outFileData)

  }
