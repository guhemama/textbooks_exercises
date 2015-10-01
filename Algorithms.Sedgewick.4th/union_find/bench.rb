require 'benchmark'
require_relative 'quick_find'
require_relative 'quick_union'

def test_class(klass)
  uf = nil

  File.open('mediumUF.txt').each do |line|
    p, q = line.split.map(&:to_i)

    # First line (elements number)
    if q.nil?
      uf = Object.const_get(klass).new(p)
      next
    end

    next if uf.connected?(p, q)

    uf.union(p, q)
  end
end

Benchmark.bm do |bm|
  %w( QuickFind QuickUnion ).each do |oper|
    bm.report(oper) { test_class oper }
  end
end