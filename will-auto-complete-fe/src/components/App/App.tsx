import { Container, Typography, Stack } from '@mui/material';
import SearchBox from '../SearchBox/SearchBox';

interface Props {}

const App = (props: Props) => {
  return (
    <Container maxWidth='sm'>
      <Stack spacing={2}>
        <Typography variant='h1' component='h2'>
          Simple Student Search
        </Typography>
        <SearchBox />
      </Stack>
    </Container>
  );
};

export default App;
