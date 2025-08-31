<div class="container" id="container">
  <div class="section" id="section-1">
    Section 1 <button onclick="showPreview('section-1')">Show Preview</button>
  </div>
  <div class="section" id="section-2">
    Section 2 <button onclick="showPreview('section-2')">Show Preview</button>
  </div>
  <div class="section" id="section-3">
    Section 3 <button onclick="showPreview('section-3')">Show Preview</button>
  </div>
  <div class="section" id="section-4">
    Section 4
  </div>
</div>

<div class="preview" id="preview-box">
  <button class="close-preview" onclick="hidePreview()">×</button>
  <div class="preview-content">Preview Content</div>
</div>
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

.preview {
  position: absolute;
  width: 40%;
  background: #d0e6ff;
  border: 1px solid #90caff;
  border-radius: 4px;
  padding: 20px;
  box-sizing: border-box;
  display: none;
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

/* ✅ Mobile: show preview stacked below */
@media (max-width: 768px) {
  .preview {
    position: static;
    width: 100%;
    margin-top: 10px;
  }
}
function showPreview(sectionId) {
  const section = document.getElementById(sectionId);
  const preview = document.getElementById('preview-box');
  const container = document.getElementById('container');
  const allSections = Array.from(document.querySelectorAll('.section'));

  const sectionRect = section.getBoundingClientRect();
  const containerRect = container.getBoundingClientRect();

  // Compute top offset (accounting for scroll)
  const topOffset = sectionRect.top - containerRect.top + window.scrollY;

  // Compute preview height (3 sections)
  const index = allSections.indexOf(section);
  let height = 0;
  for (let i = index; i < index + 3 && i < allSections.length; i++) {
    height += allSections[i].offsetHeight + 10; // include margin
  }

  // Apply styles
  if (window.innerWidth > 768) {
    // Desktop layout
    preview.style.position = 'absolute';
    preview.style.display = 'block';
    preview.style.top = `${topOffset}px`;
    preview.style.left = `${containerRect.left + container.offsetWidth + 20}px`;
    preview.style.height = `${height}px`;
  } else {
    // Mobile: stack below
    preview.style.position = 'static';
    preview.style.width = '100%';
    preview.style.display = 'block';
    preview.style.height = 'auto';
  }
}

function hidePreview() {
  const preview = document.getElementById('preview-box');
  preview.style.display = 'none';
}

