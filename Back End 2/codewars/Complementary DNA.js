function DNAStrand(dna){
    console.log(dna);
    dnaComplement = [['A','T'], ['C', 'G']];
    let oneSideDNA = dna.split('');
    let complementSide ;
    let twoSideDNA = '';  
    let setComplement;
    let letterComplement;
    oneSideDNA.forEach(element => {
        complementSide = dnaComplement[0].toString().includes(element)? dnaComplement[0].toString():dnaComplement[1].toString();
        setComplement = complementSide.toString().split(',');
        letterComplement = element.toUpperCase() == setComplement[0]?  setComplement[1] :  setComplement[0];    
        twoSideDNA = twoSideDNA.concat(letterComplement);    
    });
    console.log('array complement  ', twoSideDNA);
    return twoSideDNA;
}

dna = "GTAT"; 
DNAStrand(dna);