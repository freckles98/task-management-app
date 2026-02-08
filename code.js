import React from 'react';
import { Radar, RadarChart, PolarGrid, PolarAngleAxis, PolarRadiusAxis, ResponsiveContainer } from 'recharts';

const data = [
  { subject: 'Drive for Results', A: 87, fullMark: 100 }, // Source: PDF pg 6
  { subject: 'Problem Solving', A: 86, fullMark: 100 },   // Source: PDF pg 6
  { subject: 'Accountability', A: 80, fullMark: 100 },    // Source: PDF pg 6
  { subject: 'Communication', A: 79, fullMark: 100 },     // Source: PDF pg 6
  { subject: 'Teamwork', A: 75, fullMark: 100 },          // Source: PDF pg 6
  { subject: 'Emotional Int', A: 71, fullMark: 100 },     // Source: PDF pg 6
];

const Dashboard = () => {
  return (
    <div className="bg-gray-50 min-h-screen font-sans">
      {/* Top Navigation */}
      <nav className="bg-white border-b border-gray-200 px-6 py-4 flex justify-between items-center">
        <div className="flex items-center gap-2">
          <div className="w-8 h-8 bg-red-600 rounded-md flex items-center justify-center text-white font-bold">R</div>
          <span className="font-bold text-xl text-gray-800">Red Rocket</span>
        </div>
        <div className="flex items-center gap-4">
          <span className="text-sm text-gray-500">2025 Cycle (Finalized)</span>
          <div className="flex items-center gap-2">
            <div className="w-8 h-8 bg-gray-200 rounded-full"></div>
            <span className="font-medium text-sm">Braam Groenewald</span>
          </div>
        </div>
      </nav>

      <main className="max-w-7xl mx-auto px-6 py-8">
        
        {/* Header Stats Row */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
          <div className="bg-white p-6 rounded-xl shadow-sm border border-gray-100">
            <p className="text-gray-500 text-sm font-medium">Overall Score</p>
            <div className="flex items-baseline gap-2 mt-2">
              <span className="text-3xl font-bold text-gray-900">79%</span>
              <span className="text-xs font-medium text-green-600 bg-green-50 px-2 py-1 rounded-full">High Performing</span>
            </div>
          </div>
          <div className="bg-white p-6 rounded-xl shadow-sm border border-gray-100">
            <p className="text-gray-500 text-sm font-medium">Top Strength</p>
            <div className="flex items-baseline gap-2 mt-2">
              <span className="text-3xl font-bold text-gray-900">87</span>
              <span className="text-sm text-gray-600">Drive for Results</span>
            </div>
          </div>
          <div className="bg-white p-6 rounded-xl shadow-sm border-l-4 border-l-amber-400">
            <p className="text-gray-500 text-sm font-medium">Focus Area</p>
            <div className="flex items-baseline gap-2 mt-2">
              <span className="text-3xl font-bold text-gray-900">71</span>
              <span className="text-sm text-gray-600">Emotional Intelligence</span>
            </div>
            <button className="mt-3 text-sm text-red-600 font-medium hover:text-red-700">View Resources →</button>
          </div>
        </div>

        {/* Main Content Split */}
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
          
          {/* Left: Radar Chart */}
          <div className="bg-white p-6 rounded-xl shadow-sm border border-gray-100 min-h-[400px]">
            <h3 className="text-lg font-bold text-gray-800 mb-6">Competency Profile</h3>
            <div className="h-[300px] w-full">
              <ResponsiveContainer width="100%" height="100%">
                <RadarChart cx="50%" cy="50%" outerRadius="80%" data={data}>
                  <PolarGrid stroke="#e5e7eb" />
                  <PolarAngleAxis dataKey="subject" tick={{ fill: '#4b5563', fontSize: 12 }} />
                  <PolarRadiusAxis angle={30} domain={[0, 100]} tick={false} axisLine={false} />
                  <Radar
                    name="Braam"
                    dataKey="A"
                    stroke="#dc2626"
                    strokeWidth={3}
                    fill="#dc2626"
                    fillOpacity={0.1}
                  />
                </RadarChart>
              </ResponsiveContainer>
            </div>
          </div>

          {/* Right: Detailed Breakdown */}
          <div className="bg-white p-6 rounded-xl shadow-sm border border-gray-100">
            <h3 className="text-lg font-bold text-gray-800 mb-6">Detailed Scores</h3>
            <div className="space-y-5">
              {[
                { label: 'Drive for Results', score: 87, color: 'bg-green-500' },
                { label: 'Problem Solving', score: 86, color: 'bg-green-500' },
                { label: 'Accountability', score: 80, color: 'bg-green-500' },
                { label: 'Communication', score: 79, color: 'bg-emerald-400' },
                { label: 'Teamwork', score: 75, color: 'bg-emerald-400' },
                { label: 'Emotional Int', score: 71, color: 'bg-amber-400' },
              ].map((item) => (
                <div key={item.label}>
                  <div className="flex justify-between mb-1">
                    <span className="text-sm font-medium text-gray-700">{item.label}</span>
                    <span className="text-sm font-bold text-gray-900">{item.score}</span>
                  </div>
                  <div className="w-full bg-gray-200 rounded-full h-2.5">
                    <div className={`${item.color} h-2.5 rounded-full`} style={{ width: `${item.score}%` }}></div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>



      </main>
    </div>
  );
};

export default Dashboard;