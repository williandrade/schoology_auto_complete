import { render, screen } from '@testing-library/react';
import SearchBox from './SearchBox';

test('render input', () => {
  render(<SearchBox />);
  const linkElement = screen.getByRole('combobox');
  expect(linkElement).toBeInTheDocument();
});
