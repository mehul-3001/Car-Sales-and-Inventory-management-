import React, { useRef, useState, useEffect } from 'react';
import './PreviewLayout.css';

const sectionsData = [
  'Section 1',
  'Section 2',
  'Section 3',
  'Section 4',
  'Section 5',
];

const PreviewLayout = () => {
  const containerRef = useRef(null);
  const sectionRefs = useRef([]);
  const previewRef = useRef(null);

  const [previewIndex, setPreviewIndex] = useState(null);
  const [previewStyle, setPreviewStyle] = useState({});
  const [isMobile, setIsMobile] = useState(window.innerWidth <= 768);

  // Update mobile flag on resize
  useEffect(() => {
    const handleResize = () => {
      setIsMobile(window.innerWidth <= 768);
    };
    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  const showPreview = (index) => {
    setPreviewIndex(index);

    if (!isMobile && containerRef.current && sectionRefs.current.length) {
      const containerRect = containerRef.current.getBoundingClientRect();
      const sectionRect = sectionRefs.current[index].getBoundingClientRect();

      // Calculate offsetTop relative to container + scroll
      const offsetTop = sectionRect.top - containerRect.top + window.scrollY;

      // Sum height of current + next 2 sections
      let height = 0;
      for (let i = index; i < index + 3 && i < sectionRefs.current.length; i++) {
        height += sectionRefs.current[i].offsetHeight + 10;
      }

      const left = containerRect.left + containerRef.current.offsetWidth + 20;

      setPreviewStyle({
        position: 'absolute',
        top: `${offsetTop}px`,
        left: `${left}px`,
        height: `${height}px`,
        display: 'block',
        width: '40%',
      });
    } else {
      // For mobile
      setPreviewStyle({
        position: 'static',
        display: 'block',
        width: '100%',
        height: 'auto',
      });
    }
  };

  const hidePreview = () => {
    setPreviewIndex(null);
    setPreviewStyle({ display: 'none' });
  };

  return (
    <div>
      <div className="container" ref={containerRef}>
        {sectionsData.map((title, index) => (
          <div
            key={index}
            className="section"
            ref={(el) => (sectionRefs.current[index] = el)}
          >
            {title}
            <button onClick={() => showPreview(index)}>Show Preview</button>
          </div>
        ))}
      </div>

      {previewIndex !== null && (
        <div className="preview" ref={previewRef} style={previewStyle}>
          <button className="close-preview" onClick={hidePreview}>×</button>
          <div className="preview-content">
            Preview for: <strong>{sectionsData[previewIndex]}</strong>
          </div>
        </div>
      )}
    </div>
  );
};

export default PreviewLayout;
body {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
}

.container {
  max-width: 1000px;
  margin: 0 auto;
  position: relative;
}

.section {
  background: #f9f9f9;
  padding: 20px;
  margin: 10px 0;
  border: 1px solid #ccc;
  position: relative;
}

.section button {
  margin-left: 20px;
}

.preview {
  background: #d0e6ff;
  border: 1px solid #90caff;
  border-radius: 4px;
  padding: 20px;
  box-sizing: border-box;
  z-index: 10;
}

.close-preview {
  position: absolute;
  top: 8px;
  right: 10px;
  background: transparent;
  border: none;
  font-size: 20px;
  cursor: pointer;
}

/* Mobile responsive layout */
@media (max-width: 768px) {
  .preview {
    position: static !important;
    width: 100% !important;
    height: auto !important;
    margin-top: 10px;
  }
}


