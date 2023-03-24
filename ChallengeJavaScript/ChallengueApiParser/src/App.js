import {useEffect, useState} from 'react';
import './App.scss';
import Species from './Species';

const API_URL = 'https://swapi.dev/api/films/2/';
const SPECIES_IMAGES = {
  droid:
    'https://static.wikia.nocookie.net/starwars/images/f/fb/Droid_Trio_TLJ_alt.png',
  human:
    'https://static.wikia.nocookie.net/starwars/images/3/3f/HumansInTheResistance-TROS.jpg',
  trandoshan:
    'https://static.wikia.nocookie.net/starwars/images/7/72/Bossk_full_body.png',
  wookie:
    'https://static.wikia.nocookie.net/starwars/images/1/1e/Chewbacca-Fathead.png',
  "yoda's species":
    'https://static.wikia.nocookie.net/starwars/images/d/d6/Yoda_SWSB.png',
};
const CM_TO_IN_CONVERSION_RATIO = 2.54;

function App() {
  const [species, setSpecies] = useState([]);
  const [isFetching, setIsFetching] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    setIsFetching(true);
    fetch(API_URL)
      .then(response => response.json())
      .then(data => {
        const speciesUrls = data.species;
        const speciesRequests = speciesUrls.map(url =>
          fetch(url).then(response => response.json())
        );
        Promise.all(speciesRequests)
          .then(speciesData => setSpecies(speciesData))
          .catch(error => console.error(error))
          .finally(() => setIsFetching(false));
      })
      .catch(error => {
        setError(error);
        console.error(error);
      });
  }, []);

  return (
    <div className="App">
      <h1>Empire Strikes Back - Species Listing</h1>
      {isFetching ? (
        <p>Loading...</p>
      ) : error ? (
        <p>Something went wrong</p>
      ) : (
        <div className="App-species">
          {species.map((species, index) => (
            <Species
              key={index}
              name={species.name}
              classification={species.classification}
              designation={species.designation}
              height={
                !isNaN(species.average_height)
                  ? `${Math.ceil(
                      species.average_height / CM_TO_IN_CONVERSION_RATIO
                    )}"`
                  : species.average_height
              }
              numFilms={species.films.length}
              image={SPECIES_IMAGES[species.name.toLowerCase()]}
              language={species.language}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export default App;
