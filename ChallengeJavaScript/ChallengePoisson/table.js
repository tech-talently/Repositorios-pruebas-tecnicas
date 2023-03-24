// A row-major data structure consists of records/instances or rows from a database, in javascript, an implementation consists of an array of objects. e.g.

const records = [
  { name: 'alice', age: 25 },
  { name: 'bob', age: 50 },
  { name: 'charly', age: 30 }
]

// The fields/keys on each object are the 'column names' and each instance represents a row or a record.
// On the other hand, a column-major data structure has a more compact representation that does not repeat column names, in javascript it consists of an object of arrays e.g.

const table = {
  name: ['alice', 'bob', 'charly'],
  age: [25, 50, 30]
}

// We can think that `table` is a pivot of `records` and vice-versa
// Implement `pivotRecords` such that given a row-major data structure (array of objects ) it will return a column-major data structure i.e. object of arrays. In other words:
// pivotRecords(records) is equal to `table`

export const pivotRecords = records => {
  /* transform records into a table */
}
