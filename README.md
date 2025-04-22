
// === Copy all styles ===
    const headElements = document.head.querySelectorAll('link[rel="stylesheet"], style');
    headElements.forEach((node) => {
      extWin.document.head.appendChild(node.cloneNode(true));
    });

    setIsReady(true);

// Copy styles from main document to new window
Array.from(document.styleSheets).forEach((styleSheet) => {
  try {
    const rules = styleSheet.cssRules;
    const newStyleEl = externalWindow.current!.document.createElement('style');
    for (let i = 0; i < rules.length; i++) {
      newStyleEl.appendChild(document.createTextNode(rules[i].cssText));
    }
    externalWindow.current!.document.head.appendChild(newStyleEl);
  } catch (e) {
    // May throw security error for cross-origin stylesheets
    console.warn('Could not copy styles:', e);
  }
});
// PopoutWindow.tsx



import React, { useEffect, useRef } from 'react';
import ReactDOM from 'react-dom';

interface PopoutWindowProps {
  onClose?: () => void;
  children: React.ReactNode;
  title?: string;
  width?: number;
  height?: number;
}

const PopoutWindow: React.FC<PopoutWindowProps> = ({
  onClose,
  children,
  title = 'Popout',
  width = 600,
  height = 400,
}) => {
  const containerRef = useRef<HTMLDivElement | null>(null);
  const externalWindow = useRef<Window | null>(null);

  useEffect(() => {
    containerRef.current = document.createElement('div');
    const left = window.screenX + 100;
    const top = window.screenY + 100;

    externalWindow.current = window.open(
      '',
      '',
      `width=${width},height=${height},left=${left},top=${top}`
    );

    if (!externalWindow.current) return;

    externalWindow.current.document.title = title;
    externalWindow.current.document.body.appendChild(containerRef.current);

    const currentWindow = externalWindow.current;

    const handleUnload = () => {
      onClose?.();
    };

    currentWindow.addEventListener('beforeunload', handleUnload);

    return () => {
      currentWindow.removeEventListener('beforeunload', handleUnload);
      currentWindow.close();
    };
  }, []);

  return containerRef.current
    ? ReactDOM.createPortal(children, containerRef.current)
    : null;
};

export default PopoutWindow;

import React, { useState } from 'react';
import PopoutWindow from './PopoutWindow';

const App = () => {
  const [showPopout, setShowPopout] = useState(false);

  const handleAction = () => {
    alert('Function in main window was triggered!');
  };

  return (
    <div>
      <button onClick={() => setShowPopout(true)}>Open Popout</button>

      {showPopout && (
        <PopoutWindow onClose={() => setShowPopout(false)} title="My Popout">
          <MyComponent onDoSomething={handleAction} />
        </PopoutWindow>
      )}
    </div>
  );
};

const MyComponent = ({ onDoSomething }: { onDoSomething: () => void }) => (
  <div>
    <h2>This is a popout component</h2>
    <button onClick={onDoSomething}>Trigger Main Window Function</button>
  </div>
);
