import PropTypes from 'prop-types';
import './Species.scss';

const Species = ({
  name,
  classification,
  designation,
  height,
  image,
  numFilms,
  language,
}) => (
  <div className="Species">
    <h2>{name}</h2>
    <img src={image} alt={name} width={200} height={100} />
    <div className="Species-data">
      <p>
        <strong>Classification:</strong> {classification}
      </p>
      <p>
        <strong>Designation:</strong> {designation}
      </p>
      <p>
        <strong>Language:</strong> {language}
      </p>
      <p>
        <strong>Avg. Height:</strong> {height}
      </p>
      <p>
        <strong>Number of Films:</strong> {numFilms}
      </p>
    </div>
  </div>
);

Species.propTypes = {
  name: PropTypes.string.isRequired,
  classification: PropTypes.string.isRequired,
  designation: PropTypes.string.isRequired,
  height: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  numFilms: PropTypes.number.isRequired,
  language: PropTypes.string.isRequired,
};

export default Species;
