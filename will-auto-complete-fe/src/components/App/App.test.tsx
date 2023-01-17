import { render, screen } from '@testing-library/react';
import App from './App';

test('render page', () => {
  render(<App />);
  const linkElement = screen.getByText(/Simple Student Search/i);
  expect(linkElement).toBeInTheDocument();
});
