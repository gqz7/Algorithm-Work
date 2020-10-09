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

const request = {
  path: '',      //path to directory
  fileName: '', //the base file name for the number files
  key: '',     //key of object that contains array
  start: 0,   //start number for file numbering
  limit: 0,  //how many number files are include in compliation
  outFileName: 'compiled' //name of file created from complied array
}

compileJson(request)