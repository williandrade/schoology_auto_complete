import { debounce, Autocomplete, TextField } from '@mui/material';
import { useEffect, useMemo, useState } from 'react';
import { StudentAPI } from '../../api/StudentAPI';
import { StudentDTO } from '../../dto/StudentDTO';

interface Props {}

const SearchBox = (props: Props) => {
  const [value, setValue] = useState<StudentDTO | null>(null);
  const [inputValue, setInputValue] = useState('');
  const [options, setOptions] = useState<readonly StudentDTO[]>([]);

  const fetchStudentsWithDebounce = useMemo(
    () =>
      debounce((input: string, callback: (results?: readonly StudentDTO[]) => void) => {
        StudentAPI.search(input).then(callback);
      }, 400),
    []
  );

  useEffect(() => {
    let active = true;

    if (inputValue === '') {
      setOptions(value ? [value] : []);
      return undefined;
    }

    fetchStudentsWithDebounce(inputValue, (results?: readonly StudentDTO[]) => {
      if (active) {
        let newOptions: readonly StudentDTO[] = [];

        if (results) {
          newOptions = [...newOptions, ...results];
        }

        setOptions(newOptions);
      }
    });

    return () => {
      active = false;
    };
  }, [value, inputValue, fetchStudentsWithDebounce]);

  return (
    <Autocomplete
      id='student-search'
      freeSolo
      filterOptions={(x) => x}
      value={value}
      onChange={(_: any, newValue: any) => {
        setOptions(newValue ? [newValue, ...options] : options);
        setValue(newValue);
      }}
      options={options}
      renderInput={(params) => <TextField {...params} />}
      getOptionLabel={(option: any) => (typeof option === 'string' ? option : option.fullName)}
      onInputChange={(_, newInputValue) => {
        setInputValue(newInputValue);
      }}
    />
  );
};

export default SearchBox;
