import Step from "./Step";

export default function Stepper() {
  return (
    <div style={{ display: "flex", gap: "24px" }}>
      <Step
        label="1. Alpha"
        status="incomplete"
        content="Pending initial setup"
      />

      <Step
        label="2. Beta"
        status="complete"
        content="All checks passed"
      />

      <Step
        label="3. Gamma"
        status="in-progress"
        content="Currently running"
      />

      <Step
        label="4. Delta"
        status="not-started"
      />
    </div>
  );
}

.step {
  display: flex;
  align-items: flex-start;
  color: #fff;
  font-family: sans-serif;
}

.step-indicator {
  display: flex;
  align-items: center;
  margin-right: 12px;
}

.step-dot {
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: #6b7280;
  z-index: 1;
}

.step-line {
  height: 2px;
  width: 120px;
  background: #6b7280;
  margin-left: 6px;
}

.step-label {
  font-weight: 600;
}

.step-status {
  font-size: 12px;
  margin-top: 2px;
}

/* Status colors */
.step-complete .step-dot,
.step-complete .step-line {
  background: #22c55e;
}

.step-progress .step-dot,
.step-progress .step-line {
  background: #3b82f6;
}

.step-incomplete .step-dot,
.step-incomplete .step-line {
  background: #ef4444;
}

.step-not-started .step-dot,
.step-not-started .step-line {
  background: #9ca3af;
}

.step-content {
  margin-top: 6px;
  font-size: 13px;
  opacity: 0.85;
}

import React from "react";
import "./step.css";

const STATUS_CLASS = {
  complete: "step-complete",
  incomplete: "step-incomplete",
  "in-progress": "step-progress",
  "not-started": "step-not-started",
};

export default function Step({ label, status, content }) {
  return (
    <div className={`step ${STATUS_CLASS[status]}`}>
      <div className="step-indicator">
        <span className="step-dot" />
        <span className="step-line" />
      </div>

      <div className="step-info">
        <div className="step-label">{label}</div>
        <div className="step-status">{status.replace("-", " ")}</div>
        {content && <div className="step-content">{content}</div>}
      </div>
    </div>
  );
}
